-- Mejoras en la tabla daily_payment para hacer opcionales colector y segundo chofer
-- Este script debe ejecutarse en la base de datos

-- Agregar columna para segundo chofer (opcional)
ALTER TABLE daily_payment 
ADD COLUMN user_second_driver_id INT NULL,
ADD FOREIGN KEY (user_second_driver_id) REFERENCES user(user_id);

-- Asegurar que la columna user_colector_id sea nullable (si no lo es ya)
-- Nota: Si la columna ya permite NULL, este comando no afectará nada
ALTER TABLE daily_payment 
MODIFY COLUMN user_colector_id INT NULL;

-- Comentarios:
-- - La columna user_second_driver_id es opcional para permitir ingresos con un solo chofer
-- - La columna user_colector_id es opcional para permitir ingresos sin colector
-- - Ambas columnas pueden ser NULL según las necesidades del viaje
