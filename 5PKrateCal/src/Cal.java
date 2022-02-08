import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;


public class Cal {
		static HashMap<Integer,String> h1=new HashMap<>();
		static HashMap<Integer,String> h2=new HashMap<>();
		static HashMap<String,Integer> pR,MaxpR; 
		static Set<Integer> colorTest,deckTest,containcheck;
		static Set<Integer> royal=new HashSet<>();
		static Set<Integer> bigger=new  HashSet<>();
		static int[] deck,inputDeck,maxAry;
		static String showResult;
		static boolean j1,j2;
		static int deckT;
		static double maxEx;
 		Cal(){
		h1.put(1, "A");
		h1.put(11, "J");
		h1.put(12, "Q");
		h1.put(13, "K");
		
		h2.put(0, "黑桃");
		h2.put(1, "紅心");
		h2.put(2, "方塊");
		h2.put(3, "梅花");
		h2.put(4, "鬼牌");
		
		royal.add(1);
		royal.add(10);
		royal.add(11);
		royal.add(12);
		royal.add(13);
		
		bigger.add(1);
		bigger.add(11);
		bigger.add(12);
		bigger.add(13);
		}		
	
		String Color(int card) {
			int t=0;	
			while(card>13) {
				t++;
				card-=13;
			}
			if(h1.containsKey(card)) {
				return h2.get(t)+h1.get(card);
			}else {
				return h2.get(t)+String.valueOf(card);
			}
		}
		
		String Result(int[] deckIn) {
 			j1=IntStream.of(deckIn).anyMatch(x -> x==53);
 			j2=IntStream.of(deckIn).anyMatch(x -> x==54);
			int[] deck=new int[5];
			System.arraycopy(deckIn, 0, deck, 0, 5);
			colorTest=new HashSet<>();
			deckTest=new HashSet<>();
			int color;
			boolean A=false,B=false,C=false,D=false,E=false,F=false,G=false,H=false,I=false;
			//2鬼牌
			if(j1&&j2) {
				Arrays.sort(deck);
				for(int i=0;i<3;i++) {
					color=0;
					while(deck[i]>13) {
						color++;
						deck[i]-=13;
					}
					deckTest.add(deck[i]);
					colorTest.add(color);
				}
				deckT=deckTest.size();
				Arrays.sort(deck);
				if( colorTest.size()==1 )//同花
					A=true;
				if( deckT==3 ){
					if( royal.containsAll(deckTest))//大順
						B=true;
					else if(deck[2]-deck[0]<=4)//順子
						C=true;
				}
				if(deckT==1)//五梅
					I=true;
				else if(deckT==2)//鐵支
					D=true;
				else
					E=true;

			//1鬼牌
			}else if(j1||j2) {
				Arrays.sort(deck);
				for(int i=0;i<4;i++) {
					color=0;
					while(deck[i]>13) {
						color++;
						deck[i]-=13;			
					}
					deckTest.add(deck[i]);
					colorTest.add(color);
				}
				deckT=deckTest.size();
				Arrays.sort(deck);
				if(colorTest.size()==1)//同花
					A=true;
				if(deckT==4) {//四種號碼
					if(royal.containsAll(deckTest))//大順
						B=true;
					else if(deck[3]-deck[0]<=4)//順子
						C=true;
					else {
						deckTest.retainAll(bigger);
						if(deckTest.size()>=1)//大一對
							H=true;
					}
				}
				if(deckT==1)//五梅
					I=true;
				else if(deckT==2) {//兩種號碼
					if(deck[1]==deck[2])//鐵支
						D=true;
					else//葫蘆
						F=true;
				}
				if(deckT==3)//三條
					E=true;
			
			}else {//0鬼牌
				Arrays.sort(deck);
				for(int i=0;i<5;i++) {
					color=0;
					while(deck[i]>13) {
						color++;
						deck[i]-=13;			
					}
					deckTest.add(deck[i]);
					colorTest.add(color);
				}
				deckT=deckTest.size();
				Arrays.sort(deck);
				if(colorTest.size()==1)//同花
					A=true;
				if(deckT==5) {
					if(royal.containsAll(deckTest))//大順
						B=true;
					else if(deck[4]-deck[0]==4)//順子
						C=true;
				}
				if(deckT==2) {//兩種號碼
					if(deck[1]==deck[3])//鐵支
						D=true;
					else//葫蘆
						F=true;
				}
				else if(deckT==3) {//三種號碼
					if(deck[0]==deck[2]||deck[1]==deck[3]||deck[2]==deck[4])//三條
						E=true;
					else//兩對
						G=true;
				}
				else if(deckT==4) {//四種號碼
					for(int i=0;i<4;i++) {
						if(deck[i]==deck[i+1]) {
							if(bigger.contains(deck[i])) 
								H=true;
							break;
						}
					}
				}
			}
					
			if(A&&B)
				return "500";
			else if(I)
				return "200";
			else if(A&&C)
				return "120";
			else if(D)
				return "50";
			else if(F)
				return "10";
			else if(A)
				return "7";
			else if(B||C)
				return "5";
			else if(E)
				return "3";
			else if(G)
				return "2";
			else if(H)
				return "1";
			else
				return "0";
		}//end
		//d為牌組，前面固定後面為0，填滿後面且不重複後丟出去
		void helper(int lock, int index, int[] d, int last){
			if(index==5) {
				String r=Result(d);
				pR.put(r,pR.get(r)+1);
			}else {
				for(int i=last+1;i<=52;i++) {
					if(!containcheck.contains(i)) {
						d[index]=i;
						helper(lock,index+1,d,i);
						d[index]=0;
					}
				}
			}
		}
		
		HashMap<String,Integer> rate(int lock,int[]d){//鎖定牌數、導入陣列
			pR=new HashMap<>();
			pR.put("500",0);
			pR.put("200",0);
			pR.put("120",0);
			pR.put("50",0);
			pR.put("10",0);
			pR.put("7",0);
			pR.put("5",0);
			pR.put("3",0);
			pR.put("2",0);
			pR.put("1",0);
			pR.put("0",0);
			containcheck=new HashSet<>();
			for(int i=0;i<lock;i++) {
				containcheck.add(d[i]);
			}
			helper(lock,lock,d,0);			
			return pR;

		}
		
		boolean check(int[] a) {//檢測重複
			int [] c=new int[5];
			System.arraycopy(a,0,c, 0, 5);
			int i=4;
			boolean b=true;
			Arrays.sort(c);
			while(c[i]!=0&&i>0) {
				if(c[i]==c[i-1]) {
					b=false;
					break;
				}
				i--;
			}
			return b;
		}
		
		double exp(int l,int[] deck) { 
			HashMap<String,Integer> pR=rate(l,deck);
			int a;
			double ex=0,count=0;
			for(String key:pR.keySet()) {
				a=pR.get(key);
				count+=a;
				ex+=a*Integer.parseInt(key);
			}
			return ex/count;
		}
		

		void main(int[] inputDeck) {
			maxAry=new int[5];
			maxEx=0;
			for(int i=1;i<=5;i++) { //1~5
				iterdeck(0,0,i,new int[5],inputDeck);
			}
			showResult=Color(maxAry[0])+" ";
			for(int i=1;i<5;i++) {
				if(maxAry[i]!=0)
					showResult+=Color(maxAry[i])+" ";
			}			
		}

		void iterdeck(int index,int j, int lock, int[] temp, int[] deck) {
			double current=0;
			int[] temp2= {0,0,0,0,0};
			if(index<lock) {//未到最後一層
				for(int i=j;i<5;i++) {
					temp[index]=i;
					iterdeck(index+1,i+1,lock,temp,deck);
				}
			}else {//最後一層
				for(int i=0;i<lock;i++) {
					temp2[i]=deck[temp[i]];
				}
				current=exp(lock,temp2);
				if(current>maxEx) {
					MaxpR=rate(lock,temp2);
					maxEx=current;
					System.arraycopy(temp2,0,maxAry,0,5);
				}
			}
		}		
}
