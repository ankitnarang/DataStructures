package hashing;

import java.util.*;

public class TopKHotels {
    public static void main(String[] args) {
        String positiveKeywords = "breakfast beach citycenter location metro view staff price";
        String negativeKeywords = "not";
        //List<Integer> hotelIds = new ArrayList<Integer>(Arrays.asList(3,2,1,2,1));
        List<Integer> hotelIds = new ArrayList<Integer>(Arrays.asList(1,2,1,1,2));
        /*
        List<String> reviews = new ArrayList<String>(Arrays.asList(
                "This hotel has a nice view of the citycenter. The location is perfect.",
                "This hotel has a nice view of the citycenter. The location is perfect.",
                "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
                "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
                "This hotel has a nice view of the citycenter. The location is perfect."
        ));
        */
        List<String> reviews = new ArrayList<String>(Arrays.asList(
                "This hotel has a nice view of the citycenter. The location is perfect.",
                "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
                "Location is excellent, 5 minutes from citycenter. There is also metro station very close to the hotel.",
                "They said I couldn't take my dog and there were other guests with dogs! That is not fair.",
                "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."
        ));
        int k = 2;
        List<Integer> resultingHotelIds = awardTopKHotels(positiveKeywords,negativeKeywords,hotelIds,reviews,k);

        for (Integer id : resultingHotelIds){
            System.out.print(id + " ");
        }
    }

    private static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        Set<String> positiveWordsSet = new HashSet<>();
        Set<String> negativeWordsSet = new HashSet<>();

        for(String positiveWord : positiveKeywords.split(" ")){
            positiveWordsSet.add(positiveWord);
        }

        for(String negativeWord : negativeKeywords.split(" ")){
            positiveWordsSet.add(negativeWord);
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < reviews.size(); i++){
            int score = calculateScore(reviews.get(i),positiveWordsSet,negativeWordsSet);
            int hotelId = hotelIds.get(i);
            if(map.containsKey(hotelId)){
                map.put(hotelId,map.get(hotelId) + score);
            } else {
                map.put(hotelId,score);
            }
        }

        List<Hotel> hotels = new ArrayList<Hotel>();

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            Hotel hotel = new Hotel(key,value);
            hotels.add(hotel);
        }
        Collections.sort(hotels);

        List<Integer> result = new ArrayList<>();
        int count = 0;
        for(Hotel hotel : hotels){
            if (count == k){
                break;
            }
            result.add(hotel.id);
            count++;
        }

        return result;
    }

    private static int calculateScore(String review, Set<String> positiveWordsSet, Set<String> negativeWordsSet) {
        String[] words = review.split(" ");
        int score = 0;
        for(String word : words){
            if(positiveWordsSet.contains(word)){
                score += 3;
            } else if(negativeWordsSet.contains(word)){
                score -= 1;
            }
        }
        return score;
    }

}
class Hotel implements Comparable<Hotel> {
    int id;
    int score;

    public Hotel(int id, int score){
        this.id = id;
        this.score = score;
    }

    @Override
    public int compareTo(Hotel h) {
        if(this.score == h.score){
            if(h.id == id){
                return 0;
            }else if(this.id < h.id){
                return -1;
            } else {
                return 1;
            }
        } else if(this.score < h.score){
            return 1;
        } else {
            return -1;
        }
    }
}
