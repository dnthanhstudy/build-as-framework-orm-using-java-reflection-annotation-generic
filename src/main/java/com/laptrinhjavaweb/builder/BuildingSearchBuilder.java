package com.laptrinhjavaweb.builder;

public class BuildingSearchBuilder {

	private String name;

    private Integer floorarea;

    private String ward;

    private String street;

    private String direction;

    private String level;

    private String namemanager;

    private String phonemanager;

    private String district;

    private Integer numberofbasement;

    private Long staffid;

    private String[] types;

    private Integer rentpricefrom;

    private Integer rentpriceto;

    private Integer rentareafrom;

    private Integer rentareato;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getFloorarea() {
        return floorarea;
    }

    public void setFloorarea(Integer floorarea) {
        this.floorarea = floorarea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNamemanager() {
        return namemanager;
    }

    public void setNamemanager(String namemanager) {
        this.namemanager = namemanager;
    }

    public String getPhonemanager() {
        return phonemanager;
    }

    public void setPhonemanager(String phonemanager) {
        this.phonemanager = phonemanager;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getNumberofbasement() {
        return numberofbasement;
    }

    public void setNumberofbasement(Integer numberofbasement) {
        this.numberofbasement = numberofbasement;
    }

    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public Integer getRentpricefrom() {
        return rentpricefrom;
    }

    public void setRentpricefrom(Integer rentpricefrom) {
        this.rentpricefrom = rentpricefrom;
    }

    public Integer getRentpriceto() {
        return rentpriceto;
    }

    public void setRentpriceto(Integer rentpriceto) {
        this.rentpriceto = rentpriceto;
    }

    public Integer getRentareafrom() {
        return rentareafrom;
    }

    public void setRentareafrom(Integer rentareafrom) {
        this.rentareafrom = rentareafrom;
    }

    public Integer getRentareato() {
        return rentareato;
    }

    public void setRentareato(Integer rentareato) {
        this.rentareato = rentareato;
    }

   
    public BuildingSearchBuilder(Builder buildingSearchBuilder) {
        this.name = buildingSearchBuilder.name;
        this.ward = buildingSearchBuilder.ward;
        this.street = buildingSearchBuilder.street;
        this.floorarea = buildingSearchBuilder.floorarea;
        this.direction = buildingSearchBuilder.direction;
        this.level = buildingSearchBuilder.level;
        this.namemanager = buildingSearchBuilder.namemanager;
        this.phonemanager = buildingSearchBuilder.phonemanager;
        this.district = buildingSearchBuilder.district;
        this.numberofbasement = buildingSearchBuilder.numberofbasement;
        this.staffid = buildingSearchBuilder.staffid;
        this.types = buildingSearchBuilder.types;
        this.rentpricefrom = buildingSearchBuilder.rentpricefrom;
        this.rentpriceto = buildingSearchBuilder.rentpriceto;
        this.rentareafrom = buildingSearchBuilder.rentareafrom;
        this.rentareato = buildingSearchBuilder.rentareato;
    }


    public static class Builder{
        private String name;

        private String ward;

        private String street;

        private Integer floorarea;

        private String direction;

        private String level;

        private String namemanager;

        private String phonemanager;

        private String district;

        private Integer numberofbasement;

        private Long staffid;

        private String[] types;

        private Integer rentpricefrom;

        private Integer rentpriceto;

        private Integer rentareafrom;

        private Integer rentareato;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setFlooarea(Integer flooarea) {
            this.floorarea = flooarea;
            return this;
        }

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }

        public Builder setNamemanager(String namemanager) {
            this.namemanager = namemanager;
            return this;
        }

        public Builder setPhonemanager(String phonemanager) {
            this.phonemanager = phonemanager;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder setNumberofbasement(Integer numberofbasement) {
            this.numberofbasement = numberofbasement;
            return this;
        }

        public Builder setStaffid(Long staffid) {
            this.staffid = staffid;
            return this;
        }

        public Builder setTypes(String[] types) {
            this.types = types;
            return this;
        }

        public Builder setRentpricefrom(Integer rentpricefrom) {
            this.rentpricefrom = rentpricefrom;
            return this;
        }

        public Builder setRentpriceto(Integer rentpriceto) {
            this.rentpriceto = rentpriceto;
            return this;
        }

        public Builder setRentareafrom(Integer rentareafrom) {
            this.rentareafrom = rentareafrom;
            return this;
        }

        public Builder setRentareato(Integer rentareato) {
            this.rentareato = rentareato;
            return this;
        }

        public BuildingSearchBuilder build(){
            return new BuildingSearchBuilder(this);
        }
    }
}
