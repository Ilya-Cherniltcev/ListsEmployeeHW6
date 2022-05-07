package com.example.listsemployeehw6.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// =====  ошибка 500 Internal Server Error =======
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

public class OverArrayException extends RuntimeException {

}
