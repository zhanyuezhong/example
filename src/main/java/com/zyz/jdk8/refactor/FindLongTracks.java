package com.zyz.jdk8.refactor;

import com.zyz.jdk8.bo.Album;
import com.zyz.jdk8.bo.Artist;
import com.zyz.jdk8.bo.Track;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * User: 张月忠
 * Date: 2017/8/18
 * Time: 下午3:40
 * To change this template use File | Settings | File Templates.
 */

public class FindLongTracks {
    public Set<String> findLongTracks(List<Album> albums){

       return albums.stream()
               .flatMap(album ->album.getTracks().stream())
               .filter(t ->t.getTime()>60 )
               .map(Track::getName)
               .collect(toSet());

    }


    public Set<String> findNational(Album album){
      return   album.getMusicians().stream()
                .filter(a ->a.getName().startsWith("the"))
                .map(Artist::getOrgin)
                .collect(toSet());
    }


    int addUp(Stream<Integer> numbers){
       return numbers.reduce(0,(x,y)->x+y);
    }

    Set<String> megerNameAndNation(List<Artist> artists){
        return artists.stream()
                .map(a->{
                    if(a.getOrgin()!=null&&a.getName()!=null)
                        return a.getName()+","+a.getOrgin();
                    else
                        throw new RuntimeException("");
                }).collect(toSet());
    }

    List<Album> findNumberLess3(List<Album> albums){
        return albums.stream().filter(a->a.getTracks()==null||a.getTracks().size()<=3).collect(Collectors.toList());
    }

    int countMembers(List<Artist> artists){
        //return artists.stream().map(a-> a.getMembers().size()).reduce(0,(x,y)->x+y);
       return (int) artists.stream().flatMap(a ->a.getMembers().stream()).count();
    }

    int lowCaseNumber(String str){
        //str.toLowerCase()
                //Str//
        //Stream.of(str.toCharArray()).filter(c-> Character.isLowerCase((int)c))
        //List<char[]> chars = Arrays.asList(str.toCharArray());
        //str.chars()
       // List<char[]> chars = Arrays.asList(str.toCharArray());
        return (int) str.chars().filter(a->Character.isLowerCase(a)).count();
        //Arrays.asList(str.toCharArray()).stream().filter(c->Character.isLowerCase(c.)).count();


    }

    String maxLowerCaseString(List<String> strings){

        IntSummaryStatistics intSummaryStatistics = Stream.of(3, 4, 5, 6, 7).mapToInt(a -> a).summaryStatistics();
//        intSummaryStatistics.get
        Optional<String> max = strings.stream().min(Comparator.comparing(str -> lowCaseNumber(str)));
        if(max.isPresent())
            return max.get();
        return max.orElse("ddd");
    }



}

