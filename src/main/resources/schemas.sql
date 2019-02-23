DROP USER mybudget;
CREATE USER mybudget WITH PASSWORD 'batukan2';
CREATE DATABASE mybudgetdb WITH OWNER mybudget;

GRANT ALL PRIVILEGES ON DATABASE mybudgetdb TO mybudget;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO mybudget;


--
CREATE USER teamcityuser WITH ENCRYPTED PASSWORD 'teamcity';
CREATE DATABASE teamcitydb WITH OWNER teamcityuser;
GRANT ALL PRIVILEGES ON DATABASE teamcitydb TO teamcityuser;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO teamcityuser;

