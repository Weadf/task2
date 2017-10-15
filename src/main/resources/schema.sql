DROP TABLE IF EXISTS contacts;
CREATE TABLE contacts
(
  id bigserial,
  name character varying(200) NOT NULL,
  CONSTRAINT contacts_pk PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);