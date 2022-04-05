package com.mysqltest.junit;

public enum SeasonEnum {
    SPRING("春天","春意盎然"),
    WINTER("冬天","大雪纷飞");
    private final String seasonName;
    private final String seasonDesc;

    private SeasonEnum(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}
