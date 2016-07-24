/**
 * Created by lipeng on 2016/6/6.
 */
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 */
var intersection = function(nums1, nums2) {
    var hm = {};
    for (var n in nums1) {
        hm[n] = 1;
    }
    var ans = {};
    for (var n in nums2) {
        if (hm[n]) {
            ans[n] = 1;
        }
    }
    return Object.keys(ans);
};

var a = [1, 2, 2, 1]
var b = [2, 2];
console.log(intersection(a, b));