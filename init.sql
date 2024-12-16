CREATE DATABASE db_reservation;

CREATE DATABASE db_availability;

CREATE DATABASE db_room;

-- Script para insertar datos en las tablas de los servicios

-- SOAP Service: Tabla availability
INSERT INTO public.availability (room_id, room_type, available_date, status)
VALUES
    (1, 'Single', '2024-12-20', 'Available'),
    (2, 'Double', '2024-12-20', 'Occupied'),
    (3, 'Suite', '2024-12-21', 'Available'),
    (4, 'Single', '2024-12-22', 'Maintenance');

-- API REST: Tabla reservations
INSERT INTO public.reservations (reservation_id, room_number, customer_name, start_date, end_date, status)
VALUES
    (101, 101, 'Alice Johnson', '2024-12-20', '2024-12-22', 'Confirmed'),
    (102, 102, 'Bob Smith', '2024-12-21', '2024-12-23', 'Cancelled'),
    (103, 103, 'Charlie Brown', '2024-12-25', '2024-12-27', 'Confirmed'),
    (104, 104, 'Diana Prince', '2024-12-28', '2024-12-30', 'Pending');

-- Microservicio de Inventario: Tabla rooms
INSERT INTO public.rooms (room_id, room_number, room_type, status)
VALUES
    (1, 101, 'Single', 'Available'),
    (2, 102, 'Double', 'Occupied'),
    (3, 103, 'Suite', 'Available'),
    (4, 104, 'Single', 'Maintenance');