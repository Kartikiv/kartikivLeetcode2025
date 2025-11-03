class MedianFinder {
public:
    priority_queue<int> lower;
    priority_queue<int, vector<int>, greater<int>> upper;
    MedianFinder() {}

    void addNum(int num) {
        if (lower.size() == 0 || lower.top() > num) {
            lower.push(num);
            while (lower.size() - upper.size() > 1) {
                cout << lower.size() - upper.size();
                int low = lower.top();
                lower.pop();
                upper.push(low);
            }
        } else {
            upper.push(num);
            while (upper.size() - lower.size() > 1) {
                cout << upper.size() - lower.size();
                int high = upper.top();
                upper.pop();
                lower.push(high);
            }
        }
        if (upper.size() > lower.size()) {
            int x = upper.top(); upper.pop();
            lower.push(x);
        }
    }

    double findMedian() {
        if ((lower.size() + upper.size()) % 2 == 0) {
            double low = lower.top();
            double high = upper.top();
            cout << "the low is " << low << endl;
            cout << "the high is " << high << endl;
            return (low + high) / 2;
        } else {
            return lower.top();
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */