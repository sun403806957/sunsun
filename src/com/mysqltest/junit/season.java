package com.mysqltest.junit;

public class season {
    private final String seasonName ;
    private final String seasonDesc ;
    private season (String seasonName,String seasonDesc){
            this.seasonName = seasonName;
            this.seasonDesc = seasonDesc;
    }
    public static final season SPRING = new season("春天","春意盎然");
    public static final season SUMMER = new season("夏天","夏日炎炎");
    public static final season AUTUMN = new season("秋天","硕果累累");
    public static final season WENTER = new season("冬天","大雪纷飞");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
