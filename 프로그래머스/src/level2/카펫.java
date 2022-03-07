package level2;

public class 카펫 {
	
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int r = 1;;r++){
            int c = 2 + brown/2 - r;
            if(r * c == brown + yellow){
                answer[0] = Math.max(r,c);
                answer[1] = Math.min(r,c);
                break;
            }
        }
        
        return answer;
    }

}
