package com.likelion.hackaton.service;

import com.likelion.hackaton.form.QuestionForm;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    public QuestionForm getQuestion(int questionNo){
        QuestionForm questionForm = new QuestionForm(questionNo);

        switch (questionNo){
            case 1:
                questionForm.setQuestionText("오전 수업, 늦잠을 잔 당신! 둘 중 하나는 포기해야 한다.");
                questionForm.setAnswer1("어차피 사람들은 나에게 관심이 없어! 밥이나 먹자고!");
                questionForm.setAnswer2("차라리 밥을 포기하고 말지… 그래도 말끔하게 가자구! ");
                break;

            case 2:
                questionForm.setQuestionText("오늘은 뭘 입고 나가지..? 옷장에 마땅히 입을 옷이 없다.");
                questionForm.setAnswer1("에이 그냥 있는거 추르르추르리 하게 입고 다닐란다~");
                questionForm.setAnswer2("옷을 꼭 좀 사야겠는데? 이따 쇼핑하러 가야겠다! ");
                break;

            case 3:
                questionForm.setQuestionText("밖에 나왔는데.. 출근길이라 버스가 북적거린다.");
                questionForm.setAnswer1("에이 짜증나! 택시를 탄다.");
                questionForm.setAnswer2("그냥 버스에 낑겨탄다!");
                break;

            case 4:
                questionForm.setQuestionText("점심시간, 친구들과의 약속! 금강산도 식후경이지 ~");
                questionForm.setAnswer1("이 정도로는 부족해! 일단 많이 시키자!");
                questionForm.setAnswer2("다 못먹을 것 같은데? 인원수대로 시키자!");
                break;

            case 5:
                questionForm.setQuestionText("오늘 수업 끝났다! 이제 뭐하지 ? 당신의 선택은 ?");
                questionForm.setAnswer1("이제 좀 쉬어야겠다… 게임이나 하러가자! ");
                questionForm.setAnswer2("수업도 끝났겠다! 몸을 좀 움직여 볼까?");
                break;

            case 6:
                questionForm.setQuestionText("아르바이트를 좀 해볼까…? 당신은…");
                questionForm.setAnswer1("돈은 적게 주지만 상대적으로 편한 편의점");
                questionForm.setAnswer2("돈은 많이 주지만 상대적으로 힘든 상하차");
                break;
        }

        return questionForm;
    }
}
