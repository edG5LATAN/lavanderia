package com.EcoClean.lavanderia.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceCliente extends JpaRepository<Cliente, Long> {
}
