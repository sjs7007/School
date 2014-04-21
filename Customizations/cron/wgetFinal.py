# Example usage : python wgetFinal.py https://class.coursera.org/algo-004/lecture/index

import os
import urllib2
import sys #for command line args

base_link=str(sys.argv[1])
base_source=urllib2.urlopen(base_link).read()

def FindDownloadLinks(): #find download links of videos
	os.system("clear")
	count=0
	initial=0
	for i in range (0,1000):
		count=count+1
		temp='href="https://class.coursera.org'+base_link[base_link.find('.org/')+4 : base_link.find('/lecture')]+'/lecture/download.mp4?lecture_id='
		start_link=base_source.find(temp,initial)+6
		end_link=base_source.find('"',start_link)
		link=base_source[start_link:end_link]		
		title=FindTitles(start_link,count)
		fileName=title+'.mp4'
		print ("Downloading %s"%(fileName))
		if(os.access(fileName,os.F_OK)):	#if video exists, don't download it
			print "Video already downloaded, moving on to next vid!"
			print 
		else:	
			os.system("wget -c --quiet %s" %link)
			print "Video downloaded."
			print
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
	return title2

FindDownloadLinks()

