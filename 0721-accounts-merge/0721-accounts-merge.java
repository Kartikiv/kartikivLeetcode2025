import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // email -> groupId
        Map<String, Integer> emailToGroup = new HashMap<>();

        // groupId -> emails
        List<Set<String>> groupEmails = new ArrayList<>();

        // groupId -> name
        List<String> groupName = new ArrayList<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);

            // Collect all groupIds referenced by this account's emails
            Set<Integer> seenGroups = new HashSet<>();
            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);
                Integer gid = emailToGroup.get(email);
                if (gid != null) seenGroups.add(gid);
            }

            if (seenGroups.isEmpty()) {
                // Create new group
                int newG = groupEmails.size();
                groupEmails.add(new HashSet<>());
                groupName.add(name);

                for (int j = 1; j < acc.size(); j++) {
                    String email = acc.get(j);
                    groupEmails.get(newG).add(email);
                    emailToGroup.put(email, newG);
                }
            } else {
                // Merge into one main group (pick any; we pick the smallest for stability)
                int main = Integer.MAX_VALUE;
                for (int g : seenGroups) main = Math.min(main, g);

                // Ensure main group has a name (it always should)
                if (groupName.get(main) == null) groupName.set(main, name);

                // First, add this account's emails to main
                for (int j = 1; j < acc.size(); j++) {
                    String email = acc.get(j);
                    groupEmails.get(main).add(email);
                    emailToGroup.put(email, main);
                }

                // Then, merge other groups into main
                for (int g : seenGroups) {
                    if (g == main) continue;
                    Set<String> otherSet = groupEmails.get(g);
                    if (otherSet == null) continue; // already merged earlier

                    for (String email : otherSet) {
                        groupEmails.get(main).add(email);
                        emailToGroup.put(email, main);
                    }

                    // Mark merged group as deleted
                    groupEmails.set(g, null);
                    groupName.set(g, null);
                }
            }
        }

        // Build result: skip deleted groups, sort emails
        List<List<String>> res = new ArrayList<>();
        for (int g = 0; g < groupEmails.size(); g++) {
            Set<String> emails = groupEmails.get(g);
            String name = groupName.get(g);
            if (emails == null || name == null) continue;

            List<String> merged = new ArrayList<>();
            merged.add(name);

            List<String> sortedEmails = new ArrayList<>(emails);
            Collections.sort(sortedEmails);
            merged.addAll(sortedEmails);

            res.add(merged);
        }

        return res;
    }
}
