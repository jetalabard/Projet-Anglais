<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8"/>

    <xsl:template match="/questions">
        <xsl:for-each select="question">
          <xsl:text>Insert into QUESTION values("</xsl:text>
          <xsl:value-of select="id" /> <xsl:text>","</xsl:text>
          <xsl:value-of select="quest" /> <xsl:text>","</xsl:text>
          <xsl:value-of select="rep1" /><xsl:text>","</xsl:text>
          <xsl:value-of select="rep2" /> <xsl:text>","</xsl:text> 
          <xsl:value-of select="rep3" /> <xsl:text>","</xsl:text>
          <xsl:value-of select="rep4" /> <xsl:text>","</xsl:text>
          <xsl:value-of select="repJuste" /> <xsl:text>","</xsl:text>
          <xsl:value-of select="theme" /> <xsl:text>","</xsl:text>
          <xsl:value-of select="point" /> <xsl:text>","</xsl:text>
          <xsl:value-of select="niveau" /> <xsl:text>","</xsl:text>
          <xsl:value-of select="image" /> <xsl:text>");&#10;</xsl:text>
        </xsl:for-each>
    </xsl:template>
  
</xsl:stylesheet>
