package com.pli.project.algorithm.graph;

import java.util.*;

/**
 * Created by lipeng on 2016/2/13.
 */
public class ReconstructItinerary {

    public static List<String> findItinerary(String[][] tickets) {
        // construct graph
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        ArrayList<String> al = null;
        for (String[] ticket : tickets) {
            al = hm.get(ticket[0]);
            if (al == null) {
                al = new ArrayList<String>();
                hm.put(ticket[0], al);
            }
            al.add(ticket[1]);
        }
        for (ArrayList<String> curr : hm.values()) {
            Collections.sort(curr);
        }
        ArrayList<String> ans = new ArrayList<>();
        itineraryHelper("JFK", ans, hm, tickets.length + 1);
        return ans;
    }

    // hm is the graph structure. n is how many stops totally has
    public static boolean itineraryHelper(String curr, List<String> ans, HashMap<String, ArrayList<String>> hm, int n) {
        ans.add(curr);
        if (ans.size() >= n) {
            return true;
        }
        if (!hm.containsKey(curr) || hm.get(curr).isEmpty()) {
            return false;
        }
        ArrayList<String> arrivals = hm.get(curr);
        for (int i = 0; i < arrivals.size(); i++) {
            String arrival = hm.get(curr).remove(i);
            if (itineraryHelper(arrival, ans, hm, n)) {
                return true;
            }
            ans.remove(ans.size() - 1);
            arrivals.add(i, arrival);
        }
        return false;
    }

    public static void main(String[] args) {
//        String[][] itinerary = {
//                {"JFK", "SFO"},
//                {"JFK", "ATL"},
//                {"SFO", "ATL"},
//                {"ATL", "JFK"},
//                {"ATL", "SFO"}
//        };
//        String[][] itinerary = {
//                {"MUC", "LHR"},
//                {"JFK", "MUC"},
//                {"SFO", "SJC"},
//                {"LHR", "SFO"}
//        };
//        String[][] itinerary = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
//        String[][] itinerary = {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        String[][] itinerary = {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
        List<String> list = findItinerary(itinerary);
        System.out.println(list);
    }
}
