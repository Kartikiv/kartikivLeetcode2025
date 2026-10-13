class Solution {
    public String validIPAddress(String queryIP) {
        // split the string with . 
       if (queryIP.contains(".")) {
            String[] segments = queryIP.split("\\.", -1);

            if (segments.length == 4 && checkIPV4(segments)) {
                return "IPv4";
            }

        } else if (queryIP.contains(":")) {
            String[] segments = queryIP.split(":", -1);

            if (segments.length == 8 && checkIPV6(segments)) {
                return "IPv6";
            }
        }

        return "Neither";
    }
    

    public boolean checkIPV4(String[] ipSegments) {
        int index = 0;
        for (String segment : ipSegments) {
            if (segment.length() > 1 && segment.startsWith("0")|| !segment.matches("\\d{1,3}")) {
                return false;
            }
            // check Segement in the range 
            int segmentNumber = Integer.parseInt(segment);
            if (segmentNumber > 255) {
                return false;
            }
            index++;
        }

        return true;
    }

    public boolean checkIPV6(String[] ipSegments) {
        int index = 0;
        for (String segment : ipSegments) {
            if (segment.length() < 1 || segment.length() > 4|| !segment.matches("[0-9a-fA-F]+")) {
                return false;
            }
            index++;
        }
        return true;
    }
}