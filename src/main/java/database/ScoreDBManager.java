package database;

import java.util.*;

public class ScoreDBManager {
    private Map<Integer, List<Score>> scoreMap = new HashMap<>();
    private Map<Grade, Score> gradeMap = new HashMap<>();

    public void save(int session, Score score){
        scoreMap.getOrDefault(session, new ArrayList<Score>()).add(score);
    }

    public void scoreSet(int session, Score score){
        List<Score> scoreList = scoreMap.get(session);
        for(Score s : scoreList){
            if(s.id.equals(score.id)){
                scoreList.add(score);
            }
        }
    }

}
