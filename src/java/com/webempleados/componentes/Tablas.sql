CREATE TABLE CARGOS
 (
    codigo_car        NUMBER,
    descripcion_car VARCHAR2 (20)
  ) ;


CREATE TABLE EMPLEADOS
  (
    identificacion_emp NUMBER (10) ,
    nombres_emp        VARCHAR2 (40) ,
    apellido1_emp      VARCHAR2 (20) ,
    apellido2_emp      VARCHAR2 (20) ,
    direccion_emp      VARCHAR2 (60) ,
    telefono_emp       NUMBER (7) ,
    cargo_emp          NUMBER 
  ) ;