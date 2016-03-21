package com.pli.project.algorithm.ms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lipeng on 2016/3/18.
 */
public class UniqueIP {

    public List<String> getUniqueIP(String[][] ips) {
        HashMap<String, String> hm = new HashMap<>();
        for (String[] ip : ips) {
            String value = hm.get(ip[0]);
            if (value == null) {
                hm.put(ip[0], ip[1]);
                continue;
            }
            if (!value.equals("Duplicate")) {
                hm.put(ip[0], "Duplicate");
            }
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, String> entry : hm.entrySet()) {
            if (!entry.getValue().equals("Duplicate")) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[][] ips = {
                {"ip1", "ip2"},
                {"ip3", "ip4"},
                {"ip3", "ip2"},
                {"ip5", "ip6"},
                {"ip7", "ip8"}
        };
        UniqueIP uniqueIP = new UniqueIP();
        List<String> ans = uniqueIP.getUniqueIP(ips);
        System.out.println(ans);
    }



}
