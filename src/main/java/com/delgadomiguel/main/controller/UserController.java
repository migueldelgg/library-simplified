package com.delgadomiguel.main.controller;

import com.delgadomiguel.main.domain.User;
import com.delgadomiguel.main.requests.UserPostRequestBody;
import com.delgadomiguel.main.requests.UserPutRequestBody;
import com.delgadomiguel.main.services.UserService;
import com.delgadomiguel.main.util.DateUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Log4j2
public class UserController {
    private final UserService userService;
    private final DateUtil dateUtil;

    @GetMapping
    public ResponseEntity<List<User>> list(){
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(userService.listAll());
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserPostRequestBody userPostRequestBody) {
        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable long id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace (@RequestBody @Valid UserPutRequestBody userPutRequestBody) throws BadRequestException {
        userService.replace(userPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
