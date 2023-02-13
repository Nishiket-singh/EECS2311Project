package model;

public class RequestEverything{
    private String q, sources, domains, from, to, language, sortBy, pageSize, page;

    private RequestEverything(Builder builder){
        this.q = builder.q;
        this.sources = builder.sources;
        this.domains = builder.domains;
        this.from = builder.from;
        this.to = builder.to;
        this.language = builder.language;
        this.sortBy = builder.sortBy;
        this.pageSize = builder.pageSize;
        this.page = builder.page;
    }

    public String getQ() {
        return q;
    }

    public String getSources() {
        return sources;
    }

    public String getDomains() {
        return domains;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getLanguage() {
        return language;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getPageSize() {
        return pageSize;
    }

    public String getPage() {
        return page;
    }

    public static class Builder {
        private String q, sources, domains, from, to, language, sortBy, pageSize, page;

        public Builder q(String q){
            this.q = q;
            return this;
        }

        public Builder sources(String sources){
            this.sources = sources;
            return this;
        }

        public Builder domains(String domains){
            this.domains = domains;
            return this;
        }

        public Builder from(String from){
            this.from = from;
            return this;
        }

        public Builder to(String to){
            this.to = to;
            return this;
        }

        public Builder language(String language){
            this.language = language;
            return this;
        }

        public Builder sortBy(String sortBy){
            this.sortBy = sortBy;
            return this;
        }

        public Builder pageSize(int pageSize){
            this.pageSize = String.valueOf(pageSize);
            return this;
        }

        public Builder page(int page){
            this.page = String.valueOf(page);
            return this;
        }

        public RequestEverything build(){
            return new RequestEverything(this);
        }
    }

}