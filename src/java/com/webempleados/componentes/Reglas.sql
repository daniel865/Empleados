ALTER TABLE CARGOS ADD CONSTRAINT CARGOS_PK PRIMARY KEY ( codigo_car );
ALTER TABLE CARGOS ADD CONSTRAINT NN_DESCRIPCION_CAR CHECK( descripcion_car is not null ); 
ALTER TABLE EMPLEADOS ADD CONSTRAINT EMPLEADOS_PK PRIMARY KEY ( identificacion_emp ) ;  
ALTER TABLE EMPLEADOS ADD CONSTRAINT NN_NOMBRES_EMP CHECK ( nombres_emp is not null );
ALTER TABLE EMPLEADOS ADD CONSTRAINT NN_APELLIDO1_EMP CHECK ( apellido1_emp is not null );
ALTER TABLE EMPLEADOS ADD CONSTRAINT NN_DIRECCION_EMP CHECK ( direccion_emp is not null );   
ALTER TABLE EMPLEADOS ADD CONSTRAINT EMPLEADOS_CARGOS_FK FOREIGN KEY ( cargo_emp ) REFERENCES CARGOS ( codigo_car ) ;
