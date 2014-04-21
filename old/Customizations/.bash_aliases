alias ins='sudo -s apt-get --yes --force-yes install'
alias f='sudo find . -name '
alias cl='clear'
alias search='apt-cache search'
alias pi='ssh pi@192.168.2.8' #ssh into pi
alias sendtopi=' rsync -avz -h --delete --partial --progress ~/Desktop/toPi/ pi@192.168.2.8:/media/sj/fromLappy' #send files to pi
alias desk='ssh shinchan@192.168.2.4'
alias lappy='ssh shinchan@192.168.2.5'
alias synctopi='scp ~/.bash_aliases pi@192.168.2.8:~/'
alias synctolap='scp ~/.bash_aliases shinchan@192.168.2.5:~/'
alias synctodesk='scp ~/.bash_aliases shinchan@192.168.2.4:~/'
alias rs='rsync -a --partial -h --progress'
alias al='nano ~/.bash_aliases; . ~/.bashrc;clear' #edit alias,run it
alias ut='uptime'
#alias tr='transmission'
alias sms='cd ~ ;python ~/sms4.py'
alias log='cat ~/sms4log.txt | tail -9'
alias am='alsamixer'
alias kl='killall -9 gedit sublime_text nautilus chromium-browser firefox vlc transmission update-manager file-roller;exit'
alias fr='firefox'
alias m='cd ~/streamPi;vlc -L *.mp3'
alias v='cd ~/streamPi/youtube;vlc -L *.mp4'
alias c='chromium-browser'
alias syncf='time rsync -av --progress -h /home/shinchan/sitcomsLappy/ shinchan@192.168.2.4:/media/shinchan/sitcomsLappy'
alias cr='~/cron/./syncDown3.sh' #run sync cron manually
alias s='sublime-text'
alias r='sudo pkill X'

alias gc='git clone'
alias gp='git push'

alias asm='cd ~/masm611/MASM611/BIN'
alias gag='~/cron/./run9gag.sh'

#vim
alias copy='cp ~/ritchie/old/template.c'
alias copy2='cp ~/School/Java/template.java'
alias del='mv *.c ~/ritchie/old; cp ~/ritchie/old/template.c ~/ritchie/template.c'
alias vimc='vim ~/.vimrc'
alias c='cd ~/ritchie'
alias j='cd ~/School/Java'
