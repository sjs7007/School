;find substring

data segment
msg1 db 0dh, "Enter String 1 : $"
msg2 db 0dh, "Enter substring to be searched : $"
msg3 db 0dh, "Substring match found. $"
msg4 db 0dh, "No substring match. $"
data ends

code segment
assume ds:data, cs:code

start:
    mov ax,data ;choose ds and move
    mov ds,ax

    mov dx,offset msg1 ;display msg1
    mov ah,09h
    int 21h

	mov si,6000h ;initialize to 6000
    mov di,2000h ;initialize t0 2000
	mov cl,00h   ; to 0, will contain in end length of string

inputChar:
	mov ah,01h ;input char by chat
  	int 21h 
  	inc cl ;increment number of chars
  	mov [si],al ;store char in si
  	inc si ;increment si counter
  	cmp al,0dh ; for enter
  	jnz inputChar ;if last char is not enter, input again
  
	mov dx,offset msg2 ;display msg2
  	mov ah,09h
  	int 21h

  	mov ch,00h ; to 0, will contain in end length of substring

inputChar2:
	mov ah,01h
	int 21h
	inc ch
	mov [di],al
	inc di
	cmp al,0dh
	jnz inputChar2
	mov si,6000h
	mov di,2000h
	mov dl,ch

compareStart:
	mov al,[si]
	cmp al,[di]
	jnz reInit ;this block will contain reinitialzation code so comparision can be started again propelry
	
	inc si ; move pointer ahead in string
	dec cl ; reduce length of avail. string
	inc di ; move pointer ahead in substring
	dec dl ; reduce length of avail. substring
	cmp dl,01h ;if only length 1, end success, 1 becuase of enter
	jz outPass
	cmp cl,00h ;if  more string avail, compare, else fail
	jnz compareStart
	jmp outFail
	
reInit:
	inc si ; move to next char
	dec cl ; reduce lenght of available string
	mov dl,ch ; move length of substing to dl
	mov di,2000h ;set pointer back to start of substring
	cmp cl,00h ;if more string avail, compare 
	jnz compareStart
	;else finish
	jmp outFail


outPass:
	mov dx,offset msg3
	mov ah,09h
	int 21h
	jmp ending

outFail:
	mov dx,offset msg4
	mov ah,09h
	int 21h

ending:
  	mov ah,4ch
  	int 21h

code ends
end start

