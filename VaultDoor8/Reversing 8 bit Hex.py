char = [
    0xF4, 0xC0, 0x97, 0xF0, 0x77, 0x97, 0xC0, 0xE4, 0xF0, 0x77, 0xA4, 0xD0, 0xC5, 0x77, 0xF4, 0x86, 0xD0, 0xA5, 0x45, 0x96, 0x27, 0xB5, 0x77, 0xC2, 0xD2, 0x95, 0xA4, 0xF0, 0xD2, 0xD2, 0xC1, 0x95 
]

def reverse_swap(c):
  x = [0] * 8
  x[0] = c[4] #2
  x[1] = c[5] #3
  x[2] = c[0] #6
  x[3] = c[1] #7
  x[4] = c[6] #0
  x[5] = c[7] #1
  x[6] = c[2] #4
  x[7] = c[3] #5

  return x

combined_chars = []

for i in range(len(char)):
  value = char[i]
  bit_array = [int(bit) for bit in format(value, '08b')]
  bits = reverse_swap(bit_array)
  binary_str = ''.join(str(bit) for bit in bits)
  ascii_code = int(binary_str, 2)
  chars = chr(ascii_code)
  combined_chars.append(chars)
  print(f"Character: '{chars}'")

# Combine all characters into a single string
final_string = ''.join(combined_chars)
print(f"Combined characters: {final_string}")
