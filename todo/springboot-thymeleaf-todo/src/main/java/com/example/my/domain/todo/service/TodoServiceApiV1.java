package com.example.my.domain.todo.service;

import com.example.my.common.dto.LoginUserDTO;
import com.example.my.common.dto.ResponseDTO;
import com.example.my.common.exception.BadRequestException;
import com.example.my.domain.todo.dto.ReqTodoTableInsertDTO;
import com.example.my.domain.todo.dto.ReqTodoTableUpdateDoneYnDTO;
import com.example.my.domain.todo.dto.ResTodoTableDTO;
import com.example.my.model.todo.entity.TodoEntity;
import com.example.my.model.todo.repository.TodoRepository;
import com.example.my.model.user.entity.UserEntity;
import com.example.my.model.user.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoServiceApiV1 {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> getTodoTableData(LoginUserDTO loginUserDTO) {
        // TODO : 리파지토리에서 유저 기본키로 삭제되지 않은 할 일 목록 찾기
        // TODO : 응답 데이터로 리턴하기 (할 일 목록 조회에 성공하였습니다.)
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("할 일 목록 조회에 성공했습니다.")
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> insertTodoTableData(ReqTodoTableInsertDTO dto, LoginUserDTO loginUserDTO, HttpSession session) {
        // TODO : 할 일을 입력했는지 확인
        if (dto.getTodo().getContent() == null) {
            throw new BadRequestException("할 일을 입력하지않았습니다.");
        }
        // TODO : 리파지토리에서 유저 기본키로 삭제되지 않은 유저 찾기
        List<TodoEntity> todoEntityList = todoRepository
                .findByUserEntity_IdxAndDeleteDateIsNull(loginUserDTO.getUser().getIdx());
        // TODO : 할 일 엔티티 생성
        TodoEntity todoEntity = TodoEntity.builder()
                .idx(loginUserDTO.getUser().getIdx())
                .content(dto.getTodo().getContent())
                .build();
        // TODO : 할 일 엔티티 저장
        session.setAttribute("dto",  todoRepository.save(todoEntity));
        // TODO : 응답 데이터로 리턴하기 (할 일 추가에 성공하였습니다.)
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("할 일 추가에 성공했습니다.")
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> updateTodoTableData(Long todoIdx, ReqTodoTableUpdateDoneYnDTO dto,
            LoginUserDTO loginUserDTO) {
        // TODO : 리파지토리에서 할 일 기본키로 삭제되지 않은 할 일 찾기
        // TODO : 할 일이 null이면 (존재하지 않는 할 일입니다.) 리턴
        // TODO : 할 일 작성자와 로그인 유저가 다르면 (권한이 없습니다. )리턴
        // TODO : 할 일 doneYn 업데이트
        // TODO : 응답 데이터로 리턴하기 (할 일 수정에 성공하였습니다.)
        return null;
    }

    @Transactional
    public ResponseEntity<?> deleteTodoTableData(Long todoIdx, LoginUserDTO loginUserDTO) {
        // TODO : 리파지토리에서 할 일 기본키로 삭제되지 않은 할 일 찾기
        // TODO : 할 일이 null이면 (존재하지 않는 할 일입니다.) 리턴
        // TODO : 할 일 작성자와 로그인 유저가 다르면 (권한이 없습니다.) 리턴
        // TODO : 할 일 deleteDate 업데이트
        // TODO : 응답 데이터로 리턴하기 (할 일 삭제에 성공하였습니다.)
        return null;
    }

}
