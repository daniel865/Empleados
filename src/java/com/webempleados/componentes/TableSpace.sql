CREATE TABLESPACE WebEmpleados LOGGING
DATAFILE 'D:\BD\Web_Empleados.dbf' size 10M
extent management local segment space management auto; 

create user dba_empleados profile default 
identified by polijic
default tablespace WebEmpleados 
temporary tablespace temp 
account unlock; 

--permisos 

grant connect, resource,dba to dba_empleados; 


