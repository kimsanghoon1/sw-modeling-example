CREATE TABLE Customer (Id bigint(19) NOT NULL AUTO_INCREMENT, FirstName varchar(255), LastName varchar(255), Address varchar(255), Age int(10) NOT NULL, BirthDay date, PRIMARY KEY (Id));
CREATE TABLE Vehicle (Id bigint(19) NOT NULL AUTO_INCREMENT, CustomerId bigint(19) NOT NULL, ModelName varchar(255), Type int(10) NOT NULL, Brand varchar(255), PRIMARY KEY (Id));
ALTER TABLE Vehicle ADD INDEX FKVehicle144247 (CustomerId), ADD CONSTRAINT FKVehicle144247 FOREIGN KEY (CustomerId) REFERENCES Customer (Id);
