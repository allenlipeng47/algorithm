package com.pli.project.algorithm.exercise2014;

public class PageVisit {

}

/*
 * Q2. Given a log file of page visits of a website by different users for a day.
 * Entry in the log file is like this:
 * User 1 visited Page 4
 * User 3 visited Page 2
 * User 7 visited Page 9
 */
class User{
	int userId;
	InfoNode firstUserNode;
}

class Page{
	int pageId;
	int visitedUserNum;	//indicate this page is visited by how many users;	pages are sorted by visitedUser.
	int visitedTimes;	//indicate this page is visited by how many times in total;	pages with same visitedUser are internally sorted by visitTimes.
	InfoNode firstPageNode;
}

/*
 * UserNode LinkList is sorted by visiting times. From large to less. To solve question 3.
 */
class InfoNode{
	int pageId;	//indicate the page it belongs
	int userId;	//indicate the user it belongs
	int times;	//indicate how many times has this user visit page_belong
	InfoNode nextNodeByUser;
	InfoNode nextNodeByPage;
}
