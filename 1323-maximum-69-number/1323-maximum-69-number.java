class Solution {
public int maximum69Number (int num) {
String str="";
str=str+num;
str=str.replaceFirst("6","9");
int t=Integer.valueOf(str);
return t;
}
}