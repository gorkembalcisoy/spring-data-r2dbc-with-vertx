-- Table: public.products_new2

-- DROP TABLE public.products_new2;

CREATE TABLE public.products_new2
(
    id integer NOT NULL DEFAULT nextval('products_new2_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    price double precision,
    weight integer
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.products_new2
    OWNER to postgres;