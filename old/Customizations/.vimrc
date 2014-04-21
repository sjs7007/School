" To auto indent
set autoindent
set cindent

"no swap file
set noswapfile

" Save file
map <F4> : w
" gcc compile and run
map <F5> :w<enter> :!clear && gcc -o somename % && ./somename <CR>
map <F6> :w<enter> :!clear && javac % ; java `basename % .java` <CR>
map <F7> :w<enter> :!clear && python % <CR>

"java completions
":imap sp System.out.println("");

"auto braces and brackets
imap ( ()<left>
imap { {}<left>
imap [ []<left>

"java completions
imap sp System.out.println( 

"show line numbers
set number

" All stuff below this line is stolen from here : http://stackoverflow.com/questions/164847/what-is-in-your-vimrc

" Incremental searching is sexy
set incsearch

" Highlight things that we find with the search
set hlsearch

" Cool tab completion stuff
set wildmode=longest,list,full
set wildmenu


" Enable mouse support in console
set mouse=a

" When I close a tab, remove the buffer
set nohidden


