package com.devmath.dslist.projections;

public interface GameMinProjection {
    // Projection -> Interfaces for query returns

    // "get()" methods corresponding to the query return fields
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();

}
