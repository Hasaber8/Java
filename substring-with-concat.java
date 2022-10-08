class Solution 
{
    public List<Integer> findSubstring(String s, String[] words) 
    {
        if(words[0].length()*words.length>s.length())
            return new ArrayList<>();
        
        Map<String,Integer> word_frq=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        
        // Map store the frequency of every word in words[]
        
        for(String str:words)
            word_frq.put(str,word_frq.getOrDefault(str,0)+1);
        
        int wordlen=words[0].length();  
        
        String[] str=new String[s.length()];
        
        for(int i=0;i<wordlen;i++)
        {
            Map<String,Integer> frq=new HashMap<>();  // count frequency of words inside the window
            
            int begin=i,size=0; // size is the no. of window and begin is the starting index of window
            
            // s.length()-wordlen -> based on observation
            
            for(int j=i;j<=s.length()-wordlen;j+=wordlen)
            {
                str[j]=s.substring(j,j+wordlen);  // window
                if(word_frq.containsKey(str[j]))
                {
                    begin= begin==-1? j:begin; // begin=-1 means new window need to be started
                    frq.put(str[j],frq.getOrDefault(str[j],0)+1); 
                    size++; 
                    
                    if(size==words.length)  // substring may be possible
                    {
                        if(frq.equals(word_frq))
                            ans.add(begin);
                        
                        // sliding the window 
                        
                        frq.put(str[begin],frq.get(str[begin])-1); 
                        begin+=wordlen;  // new starting index
                        size--;
                    }
                }
                else  // reset window
                {
                    begin=-1;
                    size=0;
                    frq.clear();
                }
            }
        }
        return ans;
    }
}
PYTHON((Copied)

   res = []
    WordLen = [len(s) for s in words]
    WordIni = [  s[0] for s in words]
    TotWordLen =     sum(WordLen)
    LongestWordLen = max(WordLen)
    
    d = {}
    for i in range(len(words)):
        if words[i] not in d:
            d[words[i]] = [i]
        else:
            d[words[i]].append(i) 
            
    
    def isCCT(string):
        
        copy_d = copy.deepcopy(d)
        temp = ''
        #print('isCCT:',string,copy_d)
        
        for c in string:
            temp += c
            if temp in copy_d:
                
                if len(copy_d[temp]) > 1:
                    copy_d[temp].pop()
                else:
                    del copy_d[temp]
                temp = ''
            elif len(temp) >= LongestWordLen:
                #print('isCCT:',string, temp, 'zero patience')
                return False
        
        #print('isCCT:',string, temp)    
        if temp == '' and len(copy_d) == 0:
            return True
        else:
            return False
    
    
    for i in range(len(s)):
        if s[i] in WordIni:
            if (i + TotWordLen - 1) <= len(s): 
                testSubStr = s[i:i + TotWordLen]
                #print(i,testSubStr)
                if isCCT(testSubStr) == True:
                    res.append(i)
                
    return res
