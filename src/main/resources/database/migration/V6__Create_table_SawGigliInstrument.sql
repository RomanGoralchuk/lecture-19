CREATE TABLE saw_gigli_instrument (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	collection CHAR(50) NULL DEFAULT NULL,
    tool_design CHAR(50) NULL DEFAULT NULL,
    functional_purpose CHAR(50) NULL DEFAULT NULL,
    application_case CHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (id) USING BTREE
);