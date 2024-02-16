package com.laptrinhjavaweb.repository.custom.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;


	@SuppressWarnings("unchecked")
	@Override
	public List<BuildingEntity> searchs(BuildingSearchBuilder builder) {
		StringBuilder queryFinal = new StringBuilder(" SELECT b.* FROM building as b ");

		queryFinal = buildSqlJoinUsingBuilder(builder, queryFinal);
		queryFinal.append(SystemConstant.WHERE_ONE_EQUAL_ONE);
		queryFinal = buildSqlSpeicalUsingBuilder(builder, queryFinal);
		queryFinal = buildSqlCommonUsingBuilder(builder, queryFinal);
		queryFinal.append(" GROUP BY b.id ");

		Query query = entityManager.createNativeQuery(queryFinal.toString(), BuildingEntity.class);
		return query.getResultList();
	}

	private StringBuilder buildSqlJoinUsingBuilder(BuildingSearchBuilder builder, StringBuilder queryFinal) {
		String district = builder.getDistrict();
		Long staffid = builder.getStaffid();
		String[] types = builder.getTypes();

		if (district != null) {
			queryFinal.append(" inner join district AS d on b.districtid = d.id ");
		}
		if (staffid != null) {
			queryFinal.append(" inner join assignmentbuilding AS ab on ab.buildingid = b.id ");
		}
		if (types != null && types.length > 0) {
			queryFinal.append(" inner join buildingrenttype AS br on br.buildingid = b.id ");
			queryFinal.append(" inner join renttype AS rt on rt.id = br.renttypeid");
		}
		return queryFinal;
	}

	private StringBuilder buildSqlSpeicalUsingBuilder(BuildingSearchBuilder builder, StringBuilder queryFinal) {
		String district = builder.getDistrict();
		Long staffid = builder.getStaffid();
		Integer rentPriceFrom = builder.getRentpricefrom();
		Integer rentPriceTo = builder.getRentpriceto();
		Integer rentAreaFrom = builder.getRentareafrom();
		Integer rentAreaTo = builder.getRentareato();
		String types[] = builder.getTypes();

		if (district != null) {
			queryFinal.append(" AND d.code = '" + district + "' ");
		}
		if (staffid != null) {
			queryFinal.append(" AND ab.staffid = " + staffid);
		}
		if (rentPriceFrom != null) {
			queryFinal.append(" AND b.rentprice >= " + rentPriceFrom + " ");
		}
		if (rentPriceTo != null) {
			queryFinal.append(" AND b.rentprice <= " + rentPriceFrom + " ");
		}
		if (rentAreaFrom != null || rentAreaTo != null) {
			queryFinal.append(" AND EXISTS (SELECT ra.value FROM rentarea AS ra WHERE ra.buildingid = b.id ");
			if (rentAreaFrom != null) {
				queryFinal.append(" ra.value >= " + rentAreaFrom);
			}
			if (rentAreaTo != null) {
				queryFinal.append(" ra.value <= " + rentAreaTo);
			}
			queryFinal.append(")");
		}
		if (types != null && types.length > 0) {
			queryFinal.append(" AND rt.code IN ");
			String typesJoin = Arrays.asList(types).stream().map(item -> "'" + item + "'")
					.collect(Collectors.joining(",", "(", ")"));
			queryFinal.append(typesJoin);
		}
		return queryFinal;
	}

	private StringBuilder buildSqlCommonUsingBuilder(BuildingSearchBuilder builder, StringBuilder queryFinal) {
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				if (!fieldName.equals("district") && !fieldName.equals("staffid") && !fieldName.equals("types")
						&& !fieldName.startsWith("rentprice") && !fieldName.startsWith("rentarea")) {
					Object value = field.get(builder);
					if (value != null) {
						if (field.getType() == String.class) {
							queryFinal.append(" AND b." + fieldName + " LIKE '%" + value.toString() + "%' ");
						} else if (field.getType() == Integer.class) {
							queryFinal.append(" AND b." + fieldName + " = " + Integer.parseInt(value.toString()) + " ");
						}
					}
				}
			}
		} catch (Exception ex) {

		}
		return queryFinal;
	}

}
