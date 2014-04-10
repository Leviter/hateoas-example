hateoas-example
===============

Sample of getting HATEOAS working with different versions of a resource.

I was trying to get versioning working and ran into numerous issues. With this repository I keep track of what is 
working and what is not.

It seems that the accept header of the request to for instance 'applicaton/vnd.something+json;version=1.0', there is not
an easy/quick way to make a distinction between versions in your controller.

At the moment I got different versions to work by setting an addtional header called 'version' where I set the version I 
want to use. This seems to work, but I cannot imagine that this is the way to go. Therefor I also created a question
on the Spring forum. 

See: http://forum.spring.io/forum/spring-projects/web/747402-requestmapping-and-trying-to-map-a-version
