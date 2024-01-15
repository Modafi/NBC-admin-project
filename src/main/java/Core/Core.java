package Core;

import UIManage.UIManager;
import db.ClassReportDB;
import db.StudentDB;
import db.SubjectDB;
import db.dao.ClassReportDAO;
import db.dao.DAO;
import db.dao.StudentDAO;
import db.dao.SubjectDAO;
import db.dto.StudentDTO;
import db.dto.SubjectDTO;
import db.entity.ClassReportEntity;
import manager.ClassReportManager;
import manager.StudentManager;
import manager.SubjectManager;
import model.student.Student;
import model.subject.Subject;

import java.util.ArrayList;
import java.util.List;

import static model.subject.SubjectType.OPTIONAL;
import static model.subject.SubjectType.REQUIRED;

public class Core {
    private static Boolean flag = true;

    private static final SubjectDB subjectDB = new SubjectDB();
    private static final StudentDB studentDB = new StudentDB();
    private static final ClassReportDB classReportDB = new ClassReportDB();

    private static final DAO<StudentDTO, Student> daoStudent = new StudentDAO(studentDB);
    private static final ClassReportDAO daoClassReport = new ClassReportDAO(classReportDB);
    private static final DAO<SubjectDTO, Subject> daoSubject = new SubjectDAO(subjectDB);

    private static final StudentManager studentManager = new StudentManager(daoStudent);
    private static final ClassReportManager classReportManager = new ClassReportManager(daoClassReport);
    private static final SubjectManager subjectManager = new SubjectManager(daoSubject);

    private static final UIManager uiManager = new UIManager();


    /*


    스위치 문 모음 입니다.


     */
    public void on() {

        while(flag){

            switch (uiManager.getMenuOptions()){
                case 1:
                    studentOption();
                    break;
                case 2:
                    scoreOption();
                    break;
                default:
                    finishOption();
                    break;
            }

        }

    }

    private void studentOption() {

        switch (uiManager.getStudentOptions()){
            case 1:
                addStudent();
                break;
            case 2:
                showStudentList();
                break;
        }

    }

    private void scoreOption() {

        switch (uiManager.getScoreOptions()){
            case 1:
                addScore();
                break;
            case 2:
                editScore();
                break;
            case 3:
                showScore();
                break;
        }

    }

    private void finishOption() {
        flag = uiManager.getFinishOptions();
    }

    /*


    studentManager 관련 메소드 입니다.


     */

    private void addStudent() {
        // 1. 학생 이름을 입력 받음
        String studentName = uiManager.getNewStudentName();

        // 2. 모든 subject 를 가져옴
        List<Subject> subjects = subjectManager.getAllSubject();

        // 3. 과목 리스트 를 생성
        List<Subject> subjectList = new ArrayList<>();

        while(true){

            //1. 과목 이름 입력 받아
            Subject subject = getSubject(subjects);

            //2. 과목 이름이 과목 리스트 이름과 곂치지 않는 경우
            if(!subjectList.contains(subject)){

                //3. 과목 리스트 에 넣어
                subjectList.add(subject);

                // 4. 만약 모든 과목이 들어갈 경우
                if(subjectList.size()==11){

                    break;

                }else if(validToFinish(subjectList)){ // 5. 필수 과목 3개, 선택 과목 2개 이상일 경우

                    // 6. 또 할건지 물어봐
                    if(!uiManager.askContinue()){
                        break;
                    }

                }

            }else{ // 2. 곂칠 경우

                uiManager.showSubjectNotValidInList(); //다시 입력 하라고
            }

        }

        /*
        저장을 할 때,
        subjectList로
         */
        studentManager.addUser(studentName, subjectList);
        uiManager.showStudentsAddIsOver();
    }

    // 유효성 검사 할 것들
    // 1. 과목 이름이 곂치는 이유 => 더 입력 해야함, subjectList.contains(subject)
    // 2. 필수 과목 3개 이하일 경우 => 더 입력 해야함,
    // 3. 선택 과목 2개 이하일 경우 => 더 입력 해야함
    // 4. 과목이 꽉 찬 경우 => 그만 입력 하도록 해야됨, subjectList.size()==11

    private boolean validToFinish(List<Subject> subjectList) {
        // 2. 필수 과목 3개 이하일 경우 => 더 입력 해야함,
        // 3. 선택 과목 2개 이하일 경우 => 더 입력 해야함

        int countNe = 0;
        int countCh = 0;

        for(Subject sj : subjectList){
            if(sj.getType()==REQUIRED){
                countNe++;
            }
            if(sj.getType()==OPTIONAL){
                countCh++;
            }
        }

        return countCh > 1 && countNe > 2;
    }

    private Subject getSubject(List<Subject> subjects) {
        String subjectName = uiManager.getSubjectNameForAdd();

        Subject subject = null;

        // 1. subjects 에서 subject Name 이 있는지 확인
        boolean isValid = false;
        while(!isValid){

            for(Subject sj : subjects){

                if(sj.getName().equals(subjectName)){
                    isValid = true;
                    break;
                }

            }

            if(!isValid){
                subjectName = uiManager.getSubjectNameForAddValid();
            }

        }

        // 2. subjectList 에서 subject 이름 가져 오기
        for(Subject sj : subjects){

            if(sj.getName().equals(subjectName)){
                subject = sj;
                break;
            }

        }

        return subject;
    }

    private void showStudentList() {
        /*
        이것도 일단 대처,,,
        수정 필요 합니다.
         */
        List<Student> students = studentManager.getAllUser();
        uiManager.showStudentsList(students);
    }

    /*


     scoreManager 가 관련 되었 습니다.


     */

    private void addScore() {

        // id를 통해 student 객체를 받음
        Student student = getStudentById();

        // 이 학생의 어떤 과목을 받고 싶은지 받아 오기
        Subject subject = getSubjectInStudent(student);

        // 몇회차 입력 하고 싶은지 입력 받지
        int scoreIdx = uiManager.getScoreIdx();

        // 점수 입력 받기
        double score = uiManager.getScoreEdit(scoreIdx);

        //클래스 리포트 에 저장
        /*
        수정 필요
         */
//        classReportManager.addClassReport(student.getId(), subject.getId(), subject.getType(), score , scoreIdx);

    }

    private void editScore() {
        //id를 통해 student 객체를 받음
        Student student = getStudentById();

        //이 학생의 어떤 과목을 받고 싶은지 받아오기
        Subject subject = getSubjectInStudent(student);

        // 몇회차 입력 하고 싶은지 입력 받지
        int scoreIdx = uiManager.getScoreIdx();

        // 점수 입력 받기
        double score = uiManager.getScoreEdit(scoreIdx);

        //클래스 리포트 에 저장
        /*
        수정 필요
         */
        classReportManager.updateScore(student.getId(), subject.getId(), subject.getType(), score  , scoreIdx);
    }

    private void showScore() {
        //id를 통해 student 객체를 받음
        Student student = getStudentById();

        //이 학생의 어떤 과목을 받고 싶은지 받아 오기
        Subject subject = getSubjectInStudent(student);

        //성적 리스트 가져 오기
        /*
        수정 필요
         */
        List<ClassReportEntity> classreports =  classReportManager.getReportBySession(student.getId(), subject.getId(), subject.getType());

        uiManager.showScoreList(classreports);
    }

    private Student getStudentById() {

        //user 에게 점수를 등록할 학생의 id 를 입력 받는다.
        Long StudentId = uiManager.getStudentId();

        //studentId가 유효 한지 확인 하기
        // todo
        if(studentManager.isValidStudentId(StudentId)){
            //id를 통해 학생 객체 받아 오기
            return studentManager.getByStudent(StudentId);
        }

    }

    private Subject getSubjectInStudent(Student student) {
        String subjectName = uiManager.getSubjectName(student);
        List<Subject> subjectList = student.getSubjectList();
        Subject subject = null;
        
        for(Subject sj : subjectList){
            if(sj.getName().equals(subjectName)){
                subject = sj;
            }
        }

        return subject;
    }
}
