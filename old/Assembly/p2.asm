;max 10 - Done

data segment
msg1 db 0dh,0ah,"Enter number : $"
msg2 db 0dh,0ah,"Max. is : $"
data ends

code segment
assume cs:code,ds:data
start:
	mov ax,data
	mov ds,ax

	mov si,6000h
	mov [si],00h 
	mov cl,0ah

inputNumber:
	mov dx,offset msg1
	mov ah,09h
	int 21h

	mov ah,01h
	int 21h
	cmp al,[si]
	jge greater
	jmp checkCount

greater:
	mov [si],al
	jmp checkCount

checkCount:
	dec cl
	jnz inputNumber

display:
	mov dx,offset msg2
	mov ah,09h
	int 21h

	mov dl,[si]
	mov ah,02h
	int 21h

	mov ah,4ch
	int 21h

code ends 
end start