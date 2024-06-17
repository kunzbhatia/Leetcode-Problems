class Solution 
{
    public boolean parseBoolExpr(String expression) 
    {
        return evaluate(expression, new HashMap<>());
    }

    public static boolean evaluate(String exp, Map<String, Boolean> memo) {
        // If the expression is already evaluated, return the cached result.
        if (memo.containsKey(exp)) 
        {
            return memo.get(exp);
        }

        boolean result;

        // Base cases
        if (exp.equals("t")) 
        {
            result = true;
        } 
        else if (exp.equals("f")) 
        {
            result = false;
        } 
        else if (exp.startsWith("!")) 
        {
            // Logical NOT
            result = !evaluate(exp.substring(2, exp.length() - 1), memo); // Skip "!(" and the last ")"
        } 
        
        //LOGIC
        else 
        {
            // Logical AND or OR
            boolean isAnd = exp.startsWith("&");
            int start = 2; // Skip "&(" or "|("
            int openBrackets = 0;
            List<String> subExprs = new ArrayList<>();

            for (int i = start; i < exp.length() - 1; i++) 
            { // Skip the last ")"
                if (exp.charAt(i) == ',' && openBrackets == 0) 
                {
                    subExprs.add(exp.substring(start, i));
                    start = i + 1;
                } 
                else if (exp.charAt(i) == '(') 
                {
                    openBrackets++;
                } 
                else if (exp.charAt(i) == ')') 
                {
                    openBrackets--;
                }
            }
            // Add the last subexpression
            subExprs.add(exp.substring(start, exp.length() - 1));

            if (isAnd) 
            {
                result = true;
                for (String subExpr : subExprs) 
                {
                    result &= evaluate(subExpr, memo);
                    if (!result) break; // Short-circuit evaluation for AND
                }
            } 
            else 
            {
                result = false;
                for (String subExpr : subExprs) 
                {
                    result |= evaluate(subExpr, memo);
                    if (result) break; // Short-circuit evaluation for OR
                }
            }
        }

        // Cache the result
        memo.put(exp, result);
        return result;
    }
}
