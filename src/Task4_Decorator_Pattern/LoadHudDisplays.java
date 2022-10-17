package Task4_Decorator_Pattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadHudDisplays implements LoadDisplayInterface {
    /**
     * 정보 디스플레이 구성을 위해 디스플레이 이름들을 읽어서 리스트로 구성해서 반환하는 인터페이스
     * 인터페이스를 구현하는 클래스에서는 정보 디스플레이 구성을 일반 파일에서 디스플레이 구성 요소의 이름을 읽어서 처리함
     * load() 함수에는 구성 요소를 지정하는 파일 이름이 없기 때문에 이를 구현하는 클래스에서는 생성자 등을 통해서
     * 파일 이름을 전달 받고, load() 함수 내에서 사용할 수 있도록 해야 함
     *
     */
    /**
     * <p> 파일을 읽고 각 줄에 있는 내용을 리스트로 구성해서 반환함
     * </p>
     *
     * @param //없음
     * @return 파일에 있는 각 줄의 내용을 각각 요소로 갖는 리스트
     */
    private File file;
    public LoadHudDisplays(String filename){
            this.file = new File(filename);
    }
    public ArrayList<String> load(){
        ArrayList<String> strings = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("src/Task4_Decorator_Pattern/"+file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp = "";
            while((temp = bufferedReader.readLine())!=null){
                if(!temp.equals(""))
                    strings.add(temp);
            }
        }
        catch (IOException e){
            System.out.println("error!");
        }
        return strings;
    }
}
