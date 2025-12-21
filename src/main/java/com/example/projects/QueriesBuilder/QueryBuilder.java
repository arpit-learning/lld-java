package com.example.projects.QueriesBuilder;

@WithBuilder
public class QueryBuilder {
    private String select;
    private String from;
    private String where;
    private String join;
    private String orderBy;
    private String groupBy;

    private QueryBuilder(String select, String from, String where, String join, String orderBy, String groupBy) {
        this.select = select;
        this.from = from;
        this.where = where;
        this.join = join;
        this.orderBy = orderBy;
        this.groupBy = groupBy;
    }

    private QueryBuilder(Builder builder) {
        this(builder.select, builder.from, builder.where, builder.join, builder.orderBy, builder.groupBy);
    }

    public String getSelect() {
        return select;
    }

    public String getFrom() {
        return from;
    }

    public String getWhere() {
        return where;
    }

    public String getJoin() {
        return join;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public static class Builder {
        private String select;
        private String from;
        private String where;
        private String join;
        private String orderBy;
        private String groupBy;

        public QueryBuilder.Builder select(String select) {
            this.select = select;
            return this;
        }

        public QueryBuilder.Builder from(String from) {
            this.from = from;
            return this;
        }

        public QueryBuilder.Builder where(String where) {
            this.where = where;
            return this;
        }

        public QueryBuilder.Builder join(String join) {
            this.join = join;
            return this;
        }

        public QueryBuilder.Builder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        public QueryBuilder.Builder groupBy(String groupBy) {
            this.groupBy = groupBy;
            return this;
        }

        public QueryBuilder build() {
            return new QueryBuilder(this);
        }
    }
}