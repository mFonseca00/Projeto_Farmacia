// Define o pacote para classes de infraestrutura ou tratamento de erros.
package com.farmateste.farmateste.Infra;

// Importações necessárias.
import org.springframework.http.ResponseEntity; // Para criar respostas HTTP.
import org.springframework.web.bind.annotation.ExceptionHandler; // Para marcar métodos que tratam exceções.
import org.springframework.web.bind.annotation.RestControllerAdvice; // Para tratamento global de exceções em controllers REST.
import jakarta.persistence.EntityNotFoundException; // Exceção específica (JPA) para entidade não encontrada.

// @RestControllerAdvice: Indica que esta classe interceptará exceções
// lançadas por @RestControllers globalmente na aplicação.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler(EntityNotFoundException.class): Define que este método
    // será chamado especificamente quando uma EntityNotFoundException
    // (ou uma subclasse dela) for lançada por um controller.
    @ExceptionHandler(EntityNotFoundException.class)
    // Método handler para a exceção EntityNotFoundException.
    public ResponseEntity error404Handler(){
        // Retorna uma resposta HTTP com status 404 Not Found, sem corpo.
        // É uma forma padrão de indicar que o recurso solicitado não foi encontrado.
        return ResponseEntity.notFound().build();
    }

    // Outros métodos com @ExceptionHandler poderiam ser adicionados aqui
    // para tratar diferentes tipos de exceções e retornar respostas HTTP adequadas.
}