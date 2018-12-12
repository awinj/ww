package awin.util.seg;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aWin on 2018-12-12.
 * 分词，将句子分为多个关键词
 * @Description:
 */
public class WinSegmenter {

    public List<String> seg(String text)
    {
        List<Word> words = WordSegmenter.seg(text);
        List<String> ret=new ArrayList<String>();
        if(words!=null)
        {
            for (Word word: words) {
                ret.add(word.getText());
            }
        }
        return ret;
    }

//    public static void main(String[] args)
//    {
//        List<Word> words = WordSegmenter.seg("we are friends");
////        List<Word> words = WordSegmenter.segWithStopWords("杨尚川是APDPlat应用级产品开发平台的作者");
//        System.out.println(words);
//    }
}
