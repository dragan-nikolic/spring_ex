drop database tutorialdb;
drop user tutuser;

create user tutuser with password 'Passw0rd';
create database tutorialdb with template=template0 owner=tutuser;