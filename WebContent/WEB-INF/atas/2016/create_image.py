from wand.image import Image
# Converting first page into JPG

with Image(filename="ATA15.pdf[0]") as img:
     img.save(filename="ATA15.jpg")
