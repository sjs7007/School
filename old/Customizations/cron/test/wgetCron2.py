# For any queries, mail me at sjs7007@gmail.com!

import os
import urllib2
import sys #for command line args

#base_link='https://class.coursera.org/startup-001/lecture/index'
print "https://class.coursera.org/algo-004/lecture/index"
base_link=raw_input("Enter url of video lecture page(eg,https://class.coursera.org/startup-001/lecture/index) : ")
#base_link=str(sys.argv[1])
base_source=urllib2.urlopen(base_link).read()
#print base_source

def FindDownloadLinks(ip): #find download links of videos
	if(ip=='0'):	
		count=0
	else:
		string=ip[:ip.find('.')]
		count=int(string)
	
	initial=FindStart(ip)
	print initial
	for i in range (0,1000):
		count=count+1
		temp='href="https://class.coursera.org'+base_link[base_link.find('.org/')+4 : base_link.find('/lecture')]+'/lecture/download.mp4?lecture_id='
		start_link=base_source.find(temp,initial)+6
		end_link=base_source.find('"',start_link)
		link=base_source[start_link:end_link]		
		title=FindTitles(start_link,count)
		file=title+'.mp4'
		if(!os.access(title,os.F_OK)):	
			os.system("wget -c %s" %link)
			RenameFiles(link,count,title)
			initial=end_link
			if (i==0):
				breakval=initial
			if(initial==breakval and i!=0):
				print "break!"
				break

def RenameFiles(link,count,title): #rename files 
	file_name=link[link.find("download"):]
	toName=title+'.mp4'
	os.system("mv %s %s" %(file_name,toName))	

def FindTitles(start_link,count):
	startTitle=base_source.find('hidden">Video (MP4) for ',start_link)+24
	endTitle=base_source.find('</div>',startTitle)
	title=base_source[startTitle:endTitle]
	title=title.replace('(', '[')
	title=title.replace(')', ']')
	title2=title.replace(' ','_')
	print title
	os.system("echo %d. %s | cat >> log.txt"%(count,title))
	return title2

def FindStart(ip): #find from where to start downloading based on name of last file
	if(ip=='0'):
		return 0
	else:
		vid=ip[ip.find('.')+1:]
		temp='https://class.coursera.org'+base_link[base_link.find('.org/')+4 : base_link.find('/lecture')]+'/lecture/download.mp4?lecture_id='		
		#toFind='https://class.coursera.org/startup-001/lecture/download.mp4?lecture_id='+str(vid)
		toFind=temp+str(vid)
		#print toFind		
		startPos=base_source.find(toFind)+len(toFind)+10
		return startPos

FindDownloadLinks()
os.system("echo `date`------------------------------------------------------------------------------------------------- | cat >> log.txt")
