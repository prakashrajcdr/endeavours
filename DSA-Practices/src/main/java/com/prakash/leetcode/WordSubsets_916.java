package com.prakash.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets_916 {
	
//	Input: words1 = ["acaac","cccbb","aacbb","caacc","bcbbb"], words2 = ["c","cc","b"]
//
//	Output: ["cccbb"]
	public static void main(String[] args) {
		
		WordSubsets_916 obj = new WordSubsets_916();
		
		String[] words1 = {"acaac","cccbb","aacbb","caacc","bcbbb"} ;
		String[] words2 = {"c","cc","b"} ;
		
		
		
		obj.wordSubsets(words1, words2);

		System.out.println("res - " + obj.wordSubsets(words1, words2));
	}
	
	public List<String> wordSubsets(String[] words1, String[] words2) {
		
		List<String> outputWordSubsets = new ArrayList<>();
		
		Map<Character, Long> words2Map = this.maxFreq(words2);

		for(int i = 0; i < words1.length; i++) {
			String word1String = words1[i];
			Map<Character, Long> words1Map = this.charCount(word1String);
			Boolean wordEligible = true;
			
			for(Map.Entry<Character, Long> entry : words2Map.entrySet()) {
				if( !(wordEligible && words1Map.get(entry.getKey()) != null && words1Map.get(entry.getKey()) >= entry.getValue())) {
					wordEligible = false;
					break;
				}
			}
			
			if(wordEligible)
				outputWordSubsets.add(word1String);
		}
		
        return outputWordSubsets;
    }
	
	
	public Map<Character, Long> charCount(String input) {
		Map<Character, Long> res = new HashMap<>(input!=null && input.length() > 26 ? 26 : input.length());
		for(int i = 0; i < input.length(); i++) {
			res.put(input.charAt(i), (res.get(input.charAt(i)) == null ? 1 : res.get(input.charAt(i)) + 1));
		}
		return res;
	}
	
	public Map<Character, Long> maxFreq(String[] words2) {
		Map<Character, Long> maxFreq = new HashMap<>();

		for(String wrd2 : words2) {
			for(Map.Entry<Character, Long> entry : this.charCount(wrd2).entrySet()) {
				if(maxFreq.get(entry.getKey()) == null || entry.getValue() > maxFreq.get(entry.getKey()))
					maxFreq.put(entry.getKey(), entry.getValue());
			}
		}
		return maxFreq;
	}
	
}
