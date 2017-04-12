package univ.lecture.riotapi.model;


public class Result{
        int teamId;
        long now;
        double result;

       
        public Result(int teamId, long now, double result){
            this.teamId = teamId;
            this.now = now;
            this.result = result;
        }
        public Result(){
            this(6,System.currentTimeMillis(),0);
        }
        public int getTeamId(){
            return this.teamId;
        }

        public long getNow(){
            return this.now;
        }


        public double getResult(){
            return this.result;
        }



}
